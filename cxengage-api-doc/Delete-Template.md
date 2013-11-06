# Template Resources

## Description

Deletes the template from the given tenant.

### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested template does not exist or has already been deleted.

### Example

**Request**

```http
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

```bash
curl -IX DELETE https://api.cxengage.net/tenants/{{tenant-name}}/templates/TM1 \
 -H 'Authorization: Bearer {{token}}' \ 
```
