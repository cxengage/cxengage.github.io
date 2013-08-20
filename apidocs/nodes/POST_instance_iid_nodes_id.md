# Node Resources

```
  POST instance/:iid/nodes/:id
```

## Description

Updates the node for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — Node to be updated

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  POST instance/IN1/nodes/ND6
  Content-Type: application/json
```

```json
{
  "name": "New Node",
  "description": "Node updated by Sleepy Hollow",
  "ip-address": "127.0.0.1",
  "status": true
}
```

**Return**

```json
{
  "id": "ND6",
  "name": "New Node",
  "description": "Node updated by Sleepy Hollow",
  "ip-address": "127.0.0.1",
  "status": true
}
```
