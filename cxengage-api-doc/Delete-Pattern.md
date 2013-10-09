# Pattern Resources

```
  DELETE tenants/:iid/patterns/:id
```

## Description

Deletes the node from the given instance.

### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Pattern to delete

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant or pattern does not exist or has already been deleted.

### Example

**Request**

```
  DELETE tenants/tenant1/patterns/PT10
```

**Return**

```json

{
 "id":"PT10"
}

```
