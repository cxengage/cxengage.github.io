## Listener Resources

## Description

Retrieves listeners for the given tenant.

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/listeners HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer {{token}}
Cache-Control: no-cache
```

```json

  [
    {
        "status": true,
        "topic": "CxDemo_0720v2",
        "name": "My Salesforce Listener",
        "version": "26.0",
        "type": "salesforce",
        "mapping": {
            "user": "user__c",
            "type": "Type",
            "stage": "StageName",
            "amount": "Amount",
            "daystoclose": "daysToClose__c",
            "product": "Product__c"
        },
        "id": "LI2"
     
    },
    {
        "id": "LI1",
        "name": "Demo Datasift",
        "type": "datasift",
        "mapping": {
            "username": "interaction.author.username",
            "sentiment": "salience.content.sentiment",
            "id": "twitter.user.screen_name"
        },
        "hash": "xxxxxxxxxxxxxx",
        "status": true
    }
]
```

### curl Example
```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/listeners \ 
     -H 'Authorization: Bearer {{token}}'
```

