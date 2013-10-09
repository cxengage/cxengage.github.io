## Integration Resources

```
  GET tenants/:iid/integrations
```

## Description

Retrieves integrations for the given instance.


### Parameters

- **iid** _(required)_ — Selected tenant


### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
  GET /tenants/tenant1/integrations/datasift
```

```json

  {
    "id": "datasift",
    "api-key": "keyvalue",
    "username": "usernamevalue"
}
```
