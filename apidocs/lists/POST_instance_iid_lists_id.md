# List Resources

```
  POST instance/:iid/lists/:id
```

## Description

Updates the list for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — List to be updated

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested list or instance does not exist or has already been deleted.

### Example

**Request**

```
  POST instance/IN1/lists/LS2
  Content-Type: application/json
```

```json
{
  "name": "Event Type",
  "description": "List updated by Sleepy Hollow",
  "shortname": "eventType",
  "type": "string",
  "status": true,
  "items": ["opportunity", "case", "lead", "lateAssign", "grade", "attend"]
}
```

**Return**

```json
{
  "id":"LS2",
  "items":[
    "opportunity",
    "case",
    "lead",
    "lateAssign",
    "grade",
    "attend"
  ],
  "status":true,
  "type":"string",
  "description":"List updated by Sleepy Hollow",
  "name":"Event Type"
}
```
