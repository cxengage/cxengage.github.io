## Key Attribute Resources

```
  GET tenants/:iid/key-attribute
```

## Description

Retrieves event record for the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected tenant

### Errors

All known errors will be returned in a JSON map with key "error".

- **403 Forbidden** - You do not have access to the instance or OAuth error - see [OAuth](https://github.com/userevents/charon) for more information.
- **404 Not Found** - The requested node or instance does not exist or has been deleted.

### Example

**Request**

```
  GET /tenants/tenant-one/key-attribute
```

```json
{
    "key": "id"
}
```
 


