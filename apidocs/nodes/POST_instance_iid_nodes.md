# Node Resources

```
  POST instance/:iid/nodes
```

## Description

Creates a new node on the given instance.

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
  POST instance/IN1/nodes
  Content-Type: application/json
```

```json
{
  "name": "New Node",
  "description": "Node created by Sleepy Hollow",
  "ip-address": "127.0.0.1",
  "status": true
}
```

**Return**

```json
{
  "id": "ND1",
  "name": "New Node",
  "description": "Node created by Sleepy Hollow",
  "ip-address": "127.0.0.1",
  "status": true
}
```
