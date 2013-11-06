## Listener Resources

## Description

Retrieves listeners for the given tenant.


### Errors

All known errors will be returned in a JSON map with key "error".

- **422 Unprocessable Entity** - The requested tenant or listener does not exist or has been deleted.

### Example

**Request**

```http
GET /1.0/tenants/{{tenant-name}}/listeners/LI4 HTTP/1.1
Host: api.cxengage.net
Content-Type: application/json
Authorization: Bearer VjVYw3yJaujNoW+k5CGfe23mnJVOdhJZZ/sdrwhpZ41z
Cache-Control: no-cache
```

```json

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
        "id": "LI4"
     
    }
```

### curl Example

```bash
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/listeners/LI4 \
     -H 'Authorization: Bearer {{token}}'  
```
