# Instance Resources

```
  GET /instance/IN1
```

## Description

Retrieves instance info

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
  GET instance/IN1
```

**Return**

```json

{
    "notification-attributes": [],
    "attributes": [
        {
            "name": "custId",
            "type": "string"
        },
        {
            "name": "eventType",
            "type": "string",
            "list": "LS1"
        }
     
    ]
}

```


