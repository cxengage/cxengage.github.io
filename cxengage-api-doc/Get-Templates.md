## Template Resources

## Description

Retrieves message templates for the given tenant.


### Errors

- **422 Unprocessable Entity** - The requested template does not exist or has been deleted.

### Example

**Request**

```
GET /1.0/tenants/{{tenant-name}}/templates HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json; charset=utf-8
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
[
    {
        "id": "TM1",
        "template": "Hi {{FirstName}}, sorry we missed your call. Call Joe at
+14153159430 re: 401K needs. Gelson Bank.",
        "description": "Default SMS message with click-to-call",
        "name": "SMS"
    },
    {
        "id": "TM2",
        "template": "Hi {{first-name}}\r\n\r\nWe apologize for the
inconvenience. Please contact us at {{email-address}} at your earliest
convenience.\r\n\r\nThank You\r\n",
        "description": "Email apologizing to customer",
        "name": "Email"
    }
]
```

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/templates \
     -H 'Authorization: Bearer {{token}}'
```
