CxEngage Documentation
====================

Getting Started 
---------------

Here is some information on how to setup your instance of CxEngage 

### Event Records

CxEngage uses **Event Records** to help you create patterns and to allow the system to react as needed to various events. Event Records can be configured via the UI or via API. An Event Record contains various attributes to describe it's content, which are divided into the following types:

1. **Key Attribute**: A key attribute is what is used to identify an event record. For example, a key attribute to describe a specific customer or user could be _CustomerID_ or _UserID_. Key attributes are always the first item in an Event Record. You will only have one key attribute.
   
2. **Attributes**: A regular attribute would be something that you would like to use for your pattern. For example, if you want to write a pattern for a contact center, you could use attributes like _CallAction_ or _ToPhoneNumber_ to track when a call is placed and what number should called when a pattern is matched.


These attributes can now be used in a pattern. As an example, here is the pattern where a call gets abandoned from the IVR, and an agent calls the customer back using our integration with twilio: 

```clojure 
;;When
(event (= CallAction "AbandonedCall")

;;Then
(send twilio call {:to-phone-number *To-PhoneNumber*}))
```

If you have any further questions, do not hesitate to reach us by creating a ticket, or e-mailing CxEngage Support at [support@cxengage.com](mailto:support@cxengage.com).

### Using the Echo Endpoint

The Echo endpoint service can be used to test out your patterns. There are no mandatory parameters for the echo service. There is one optional parameter, which is 
* message

Here is a way to use the echo endpoint in your Then
```clojure
(send echo message {:message "send message"})
```

You could also test out your message template with the echo
```clojure
(send echo message {:message "send message"}
(message-template {:message +MT1}))
```

### Using the Twilio endpoint

With CxEngage you can use a Twilio service, with which you can use to send either SMS or Phone calls. To start up the Twilio endpoint service, you need the following items  

* Twilio SID
* Twilio token

With the Twilio service, you can send either sms or phone calls. The keyword to use for each of it is

* sms
* call

The mandatory parameters that the Twilio endpoint needs are 

* to-phone-number - The phone number to call via the endpoint
* from-phone-number - The from phone number that your would like the call to originate from. You get this from Twilio
* message - The message that you want 

So, to be able to use the Twilio endpoint, you need to pass in these parameters. You can do this a few different ways. 

You can use any of the event record parameters that sends in each of these values. So, if you would like to use the following event record parameters toPhoneNumber, fromPhoneNumber and message, your Then in your pattern would look like this - 

```clojure
(send twilio sms {:to-phone-number *toPhoneNumber*
                  :from-phone-number *fromPhoneNumber*
                  :message *message*})
```
You could also set these values. Lets say that your from-phone-number is always the same, you don't need to send that in, you could just write your pattern this way. 

```clojure
(send twilio call {:to-phone-number *toPhoneNumber*
                  :from-phone-number "15068009013"
                  :message *message*})
```
Note that in the pattern above, we are sending a phone call instead of sms. 

You could also use message templating instead of setting it in the pattern

```clojure
(send twilio call {:to-phone-number *toPhoneNumber*
                  :from-phone-number "15068009013"} 
      (message-template {:message +MT1}))
```

### Sendgrid endpoint

With CxEngage, you can use Sendgrid to send emails as a pattern reaction. To start up the Sendgrid Endpoint Service, you need the following items

* Sendgrid Account name
* Sendgrid Password

With the Sendgrid service, you can send emails. The keyword to use for it is

* email

The mandatory parameters that the Sendgrid endpoint needs are

* to - to email address
* from - from email address
* subject - subject of the email
* message - body of your email

So, to be able to use the Sendgrid endpoint, you need to pass in these parameters. You can do this a few different ways.

You can use any of the event record parameters that sends in each of these values. So, if you would like to use the following event record parameters to-email-address, from-email-address, subject and message, your Then in your pattern would look like this -

```clojure
(send sendgrid email {:to *to-email-address*
                      :from *from-email-address*
                      :subject *subject*
                      :message *message*})
```

You could also set your values. Let's says you want the from email address to always be no-reply@cxengage.com. You can write the pattern this way

```clojure
(send sendgrid email {:to *to-email-address*
                      :from "no-reply@cxengage.com"
                      :subject *subject*
                      :message *message*})
```

You could also use message templating for setting it in the pattern

```clojure
(send sendgrid email {:to *to-email-address*
                      :from "no-reply@cxengage.com"
                      :subject *subject*
                      :message +MT1})
```


Setting up your patterns
------------------------

Next, we get to the fun part of creating patterns for things that matter to your enterprise. To enable this we have a simple, yet powerful DSL.

### Intro to the CxEngage DSL

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

