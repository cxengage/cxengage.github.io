# Endpoint Resources

```
  GET instance/:iid/endpoints
```

## Description

Retrieves all endpoints for a given instance

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.

### Example
**Request**

```
  GET instance/IN1/endpoints
```

**Return**

```json

[
 {
  "id":"EP1",
  "name":"echo",
  "display":"Echo Endpoint",
  "params":[],
  "ui":["quote",[]],
  "sends":{"message":{"message":{"type":"optional"}}}
},

 {
   "id":"EP2",
   "name":"twilio",
   "display":"Twilio Endpoint",
   "params":["account","password"],
   "sends":{
      "call":{
              "to-phone-number":{
              "type":"mandatory"
             },
              "from-phone-number": {
              "type":"mandatory"
             },
              "message":{
              "type":"mandatory"
             }
            },
          "sms":{
              "to-phone-number":{
              "type":"mandatory"
             },
              "from-phone-number":{
              "type":"mandatory"
            },
              "message":{
              "type":"mandatory"
            }
         }
      },

  "static-params":
      ["account",
        "password"
      ],
  "ui":
      ["quote",
        [[
           "manualentry",
           "label",
           "Twilio SID:",
           "param",
           "password"],
       [   
           "manualentry",
           "label",
           "Twilio Token:",
           "param", 
           "account",
           "type",
           "password"]]]

}]

```
