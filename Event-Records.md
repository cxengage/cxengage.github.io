_Note - This is intended to be customer facing documentation and this is still a_
_draft_

CxEngage uses **Event Records** to help you create patterns and to allow the system to react as needed to various events. Event Records can be configured via the UI or via API. An Event Record contains various attributes to describe it's content, which are divided into the following types:

1. **Key Attribute**: A key attribute is what is used to identify an event record. For example, a key attribute to describe a specific customer or user could be _CustomerID_ or _UserID_. Key attributes are always the first item in an Event Record. You will only have one key attribute.
   
2. **Attributes**: A regular attribute would be something that you would like to use for your pattern. For example, if you want to write a pattern for a contact center, you could use attributes like _CallAction_ or _ToPhoneNumber_ to track when a call is placed and what number should called when a pattern is matched.


These attributes can now be used in a pattern. As an example, here is the pattern where a call gets abandoned from the IVR, and an agent calls the customer back using our integration into Avaya: 

```clojure 
;;When
(event (= CallAction "AbandonedCall")

;;Then
(send twilio call {:to-phone-number *To-PhoneNumber*}))
```

If you have any further questions, do not hesitate to reach us by creating a ticket, or e-mailing CxEngage Support at [support@cxengage.com](mailto:support@cxengage.com).
