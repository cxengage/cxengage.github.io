## Event Record Resources

```
  GET instance/:iid/event_record
```

## Description

Retrieves event record for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  GET instance/IN1/event_record
```

```json
{ "notification-attributes":[],
  "attributes":
      [
       {
        "name":"custId",
        "type":"string"
       },
       
       {
        "name":"eventType",
        "type":"string"
       },
       
       {"name":"customerSegment",
        "type":"string"
       }
      ]
}
```
 



