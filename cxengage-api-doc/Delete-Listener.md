## Listener Resources

```
  DELETE tenants/:iid/listeners/:id
```

## Description

Deletes the chosen listener from the given tenant


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ - Selected listener 

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
  DELETE tenants/tenant1/listeners/LI3
```
