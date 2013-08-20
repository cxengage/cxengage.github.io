# List Resources

```
  POST instance/:iid/lists
```

## Description

Creates a new list on the given instance.

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
  POST instance/IN1/lists
  Content-Type: application/json
```

```json
{
  "name": "Event Type",
  "description": "List created by Sleepy Hollow",
  "shortname": "eventType",
  "type": "string",
  "status": true,
  "items": ["opportunity", "case", "lead", "lateAssign", "grade", "attend"]
}
```

**Return**

```json
"LS2"
```
