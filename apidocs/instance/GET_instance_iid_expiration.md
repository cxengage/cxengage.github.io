# Instance Resources
```
  GET instance/:iid/expiration
```

## Description

Retrieves the expiration of instance iid

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected instance

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  GET instances/IN1/expiration
```

**Return**

```json
  {
    "expires": "20131212T120000.000Z"
  }
```  






