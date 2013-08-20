# List Resources

```
  GET instance/:iid/lists
```

## Description

Retrieves all lists for the given instance.

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
  GET instance/IN1/lists
```

**Return**

```json
[
  {
    "id":"LS1",
    "items":[
      "lateAssign",
      "grade",
      "attend"
    ],
    "status":true,
    "type":"string",
    "description":"",
    "name":"Event Type"
  }
]
```
