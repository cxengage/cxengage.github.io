## Listener Resources

```
  GET tenants/:iid/listener/:id
```

## Description

Retrieves listeners for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant
- **id** _(required)_ - Selected listener

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant or listener does not exist or has been deleted.

### Example

**Request**

```
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

```
curl -XGET https://api.cxengage.net/tenants/{{tenant-name}}/listeners/LI4 \
     -H 'Authorization: Bearer {{token}}'  
```
