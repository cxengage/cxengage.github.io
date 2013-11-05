## Listener Resources

```
  PUT tenants/:iid/listeners/:lid
```

## Description

Retrieves listeners for the given tenant.


### Parameters

- **iid** _(required)_ — Selected tenant
- **lid** _(required)_ - Selected Listener

### Errors

All known errors will be returned in a JSON map with key "error".

- **404 Not Found** - The requested tenant does not exist or has been deleted.

### Content Type

```
Content-Type: application/json; charset=utf-8
```

### Example

**Request**

```
  PUT tenants/tenant1/listeners/LI4
```

```json

  {"name" : "Updated Name for listener"}
    
```

**Result**

```json

{
    "id": "LI4",
    "status": false,
    "topic": "CxDemo_0720v2",
    "name": "Updated Name for listener",
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
curl -XPUT https://api.cxengage.net/tenants/{{tenant-name}}/listeners/LI4 \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"Updated Name for listener"}'

```
