# Event Record Resources

```
  POST instance/:iid/event_record
```

## Description

Creates/Updates event record on given instance

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
  POST instance/IN1/event_record
  Content-Type: application/json
```

```json
{  "notification-attributes":[],
   "attributes":[
      {
       "name":"custId",
       "type":"string"
      },
      {
       "name":"eventType",
       "type":"string"
      },
      {
      "name":"customerSegment",
      "type":"string"
      }
    ]
}
```

Note - First item is considered the key attribute. E.g in the case above custId is the key attribute.

**Return**
```json
{  "notification-attributes":[],
   "attributes":[
      {
       "name":"custId",
       "type":"string"
      },
      {
       "name":"eventType",
       "type":"string"
      },
      {
      "name":"customerSegment",
      "type":"string"
      }
    ]
}
```



