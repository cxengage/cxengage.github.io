# List Resources

```
  GET instance/:iid/lists/:id
```

## Description

Retrieves the list for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — List to retrieve

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  GET instance/IN1/lists/LS1
```

**Return**

```json
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
```
