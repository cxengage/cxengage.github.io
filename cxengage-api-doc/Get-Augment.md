## Augment Resources


## Description

Retrieves augments for the given tenant.


### Mandatory Parameters

- **type** — file based or api based augment
- **service** — augment at the engine level or notification level
- **name** — name of the augment

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.


### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/augments/{{augment-id}} HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json
{
    "id": "AU1",
    "name": "API based",
    "service": "engine",
    "type": "api",
    "options": {
        "url": "http://cxengage-augment",
        "attributes": [
            "phoneNumber",
            "customerSegment"
        ]
    }
}
```
 
### curl Example

```bash
curl -X GET https://api.cxengage.net/tenants/{{tenant-name}}/augments/AU1 \
     -H 'Authorization: Bearer {{token}}'

```
