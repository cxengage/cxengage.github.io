# Node Resources

```
  DELETE instance/:iid/nodes/:id
```

## Description

Deletes the node from the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — Node to delete

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has already been deleted.

### Example

**Request**

```
  DELETE instance/IN1/nodes/ND5
```

**Return**

```json
  "ND5"
```
