## Listener Resources

```
  POST tenants/:iid/listeners
```

## Description

Retrieves listeners for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant


### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Example

**Request**

```
  POST tenants/tenant1/listeners
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
    } 
}
```
**Return**

```json
{
    "id": "LI3",
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
    }
}
```

### curl Example

```
curl -XPOST http://api.cxengage.com/tenants/{{tenant-name}}/listeners \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"Demo Datasift","type":"datasift","mapping":{"username":"interaction.author.username","sentiment":"salience.content.sentiment","id":"twitter.user.screen_name"},"hash":{{{datasift-hash}},"status":true}'
```
