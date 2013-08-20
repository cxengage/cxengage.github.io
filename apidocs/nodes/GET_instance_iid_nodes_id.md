# Node Resources

```
  GET instance/:iid/nodes/:id
```

## Description

Retrieves the node for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance
- **id** _(required)_ — Node to retrieve

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  GET instance/IN1/nodes/ND1
```

**Return**

```json
{
  "id":"ND1",
  "status":true,
  "ip-address":"127.0.0.1",
  "description":"",
  "name":"Local"
}
```
