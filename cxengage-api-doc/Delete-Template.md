# Template Resources

```
  DELETE tenants/:iid/templates/:id
```

## Description

Deletes the list from the given instance.

### Authentication

[OAuth](https://github.com/userevents/charon)

### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Template to delete

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested list or instance does not exist or has already been deleted.

### Example

**Request**

```
  DELETE tenants/tenants/templates/TM1
```

**Return**

```json
{

  "TM1"
}
```
