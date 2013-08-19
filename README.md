_Note - this is a draft. This is intended to be customer facing_

CxEngage's customer Domain-Specific Language (DSL) offers incredible flexibility, providing the ability to set up almost any type of pattern of events to match. At it's most basic, every pattern is of the form: **when** _"events happen"_ **then** _"notify or do something"_.

### "Whens"

The following keywords are available to describe the **"when"** portion of the pattern:

| When keywords|
|:-------------:|
| =             |
| >             |
| <             |
| not           |
| and           |
| or            |
| Within        |
| inSequence    |
| allOf         |
| anyOf         |
| count         |
| failWhen      |
| seconds       |
| minutes       |
| hours         |
| days          |

For example, the following is a pattern where if a customer calls into a contact center twice and abandons the call twice within an hour, then we would call the customer back:

```clojure
;;When
(within 1 hours
        (count 2 (event (= CallAction "abandoned")))
        
;Then
(send echo message {:message "Call abandoned twice, call customer back"})
```
_(Echo is used for convenience in this case to illustrate the example, but is also useful for testing your patterns.)_

Now, what if a customer calls a 3rd time and gets an agent before the agent calls back? Since we don't want the agent to call him or her back, we can account for this scenario by using the FailWhen keyword as follows: 

```clojure
;;When
(allOf (within 1 hours
                 (count 2 (event (= "CallAction" "abandoned")))))
       (failWhen (count 1 (event (= "CallAction" "answered"))))
       
;;Then
(send echo message {:message "Call abandoned twice , call customer back"}))
```



As another example, what if when a customer calls in once, talks to an agent, and then calls back within 30 minutes, we want the customer to be routed to a more experienced second-tier agent? That pattern would look like this:

```clojure
;;When
(within 30 minutes
        (inSequence (event (= "CallAction" "answered")
                    (event (= "CallAction" "inqueue"))))
                    
;Then
(send echo message {:message "Transfer call to senior agent"})
```
More info on [Writing Whens](Writing-Whens.md)

### "Thens"

The following keywords are available to describe the **"then"** portion of the pattern:

| Then keywords|
| :-----------: |
| par        |
| seq        |
| delay      |
| send       |
| if         |
| on-success |
| on-failure |
| timeout    |
| message-template |
| set |

Continuing the examples from above, we can replace the _echos_ with the above _"thens"_. Now, when a caller abandons the call twice, we can use our Twilio integration to trigger an outbound call:

```clojure
;;When
(allOf (within 1 hours
               (count 2 (event (= "CallAction" "abandoned"))))

;;Then
(send twilio call {:to-phone-number *phone-number*}))
```

If we would like to send an SMS to a customer after the two abandons to let them know they will receive a call shortly, we can write the pattern using _seq_ (short for _sequence_) as: 

```clojure
;;When
(allOf (within 1 hours
               (count 2 (event (= "CallAction" "abandoned"))))
                
;;Then
(seq
  (send twilio sms {:to-phone-number *phone-number*
                    :message "We apologize for the long waits, an agent
                              will call you back shortly"})
  (send twilio call {:to-phone-number *phone-number*}))
```

In this example, we use the _seq_ keyword because we want the SMS to go out before the agent calls
back. One thing to note here is that if the SMS fails, the next send does not execute.

More info on [Writing Thens](Writing-Thens.md)

### Platform API
