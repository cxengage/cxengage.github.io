#Pattern Resources

## Description

Retrieves chosen pattern for the given tenant.


### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant or pattern does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/patterns HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

**Return**

```json
{
  "id":"PT2",
  "when":"(when (event (= \"id\" \"1234\")))",
  "then":"(seq (send echo message {:message \"Hello world\"}))",
  "status":true,
  "description":"Sample Pattern",
  "name":"Sample Pattern"
}
```

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/patterns \
     -H 'Authorization: Bearer {{token}}'
```

