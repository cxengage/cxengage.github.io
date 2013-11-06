## Key Attribute Resources

## Description

Retrieves key attribute for the given tenant.


### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/key-attribute HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```
**Response**

```json
{
    "key": "id"
}
```
 
### curl Example

```bash
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/key-attribute \
     -H 'Authorization: Bearer {{token}}'

```
