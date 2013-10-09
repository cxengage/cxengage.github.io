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
        "status": false,
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
     
     
    }
    
```

**Result**

```json

{
    "id": "LI3",
    "status": false,
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
