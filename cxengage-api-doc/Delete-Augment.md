## Augment Resources

```
  DELETE tenants/:iid/augments/:id
```

## Description

Deletes the chosen augment from the given tenant


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ - Selected listener 

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
  DELETE tenants/tenant1/augments/AU5
```


### curl Example

```
curl -I -XDELETE https://api.cxengage.net/tenants/{{tenant-name}}/augments/AU5 \
     -H 'Authorization: Bearer {{token}}'
```
