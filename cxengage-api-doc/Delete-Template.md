# Template Resources

```
  DELETE tenants/:iid/templates/:id
```

## Description

Deletes the template from the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ — Template to delete

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested template does not exist or has already been deleted.

### Example

**Request**

```
DELETE /1.0/tenants/{{tenant-name}}/templates/TM1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

**Return**

```json
{

  "TM1"
}
```

### curl Example

```
curl -IX DELETE https://api.cxengage.net/tenants/{{tenant-name}}/templates/TM1 \
 -H 'Authorization: Bearer {{token}}' \ 
```
