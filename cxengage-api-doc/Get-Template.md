## Template Resources

## Description

Retrieves templates for the given tenant.


### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant or template does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/templates/TM1 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json

    {
        "id": "TM1",
        "template": "Hi {{FirstName}}, sorry we missed your call. Call Joe at
+14153159430 re: 401K needs. Gelson Bank.",
        "description": "Default SMS message with click-to-call",
        "name": "SMS"
    }
```

### curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/templates/TM1 \
     -H 'Authorization: Bearer {{token}}'
```
