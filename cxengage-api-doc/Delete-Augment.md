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

```http
DELETE /1.0/tenants/{{tenant-name}}/augments/AU5 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```


### curl Example

```bash
curl -I -XDELETE https://api.cxengage.net/tenants/{{tenant-name}}/augments/AU5 \
     -H 'Authorization: Bearer {{token}}'
```
