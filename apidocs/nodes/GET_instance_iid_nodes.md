# Node Resources

```
  GET instance/:iid/nodes
```

## Description

Retrieves all nodes for the given instance.

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
  GET instance/IN1/nodes
```

**Return**

```json
[
  {
    "id":"ND1",
    "status":true,
    "ip-address":"127.0.0.1",
    "description":"",
    "name":"Local"
  },
  {
    "id":"ND2",
    "status":true,
    "ip-address":"127.0.0.1",
    "description":"",
    "name":"Local2"
  },
  {
    "id":"ND3",
    "status":true,
    "ip-address":"127.0.0.1",
    "description":"",
    "name":"Local3"
  }
]
```
