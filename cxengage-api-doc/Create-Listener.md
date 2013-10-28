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

### Salesforce Listener Example

**Request**

```
  POST tenants/tenant-name/listeners
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
-d '{"name":"My Salesforce Listener","type":"salesforce","mapping":{"user":"user__c","type":"Type","stage":"StageName","amount":"Amount","daystoclose":"daysToClose__c","product": "Product__c"},"status":true}'
```

### Datasift Listener Example

**Request**

```
  POST tenants/tenant-name/listeners
```

```json

{
    "name": "sentiment listener",
    "type": "datasift",
    "mapping": {
        "username": "interaction.author.username",
        "retweet_count": "twitter.retweet.count",
        "network": "interaction.type",
        "sentiment": "salience.content.sentiment",
        "followers": "twitter.user.followers_count",
        "user_url": "interaction.author.link",
        "profile_image": "twitter.user.profile_image_url"
    },
    "hash": "datasifthash",
    "status": true
}
```
**Return**

```json
{
    "id": "LI1",
    "name": "sentiment listener",
    "type": "datasift",
    "mapping": {
        "username": "interaction.author.username",
        "retweet_count": "twitter.retweet.count",
        "network": "interaction.type",
        "sentiment": "salience.content.sentiment",
        "followers": "twitter.user.followers_count",
        "user_url": "interaction.author.link",
        "profile_image": "twitter.user.profile_image_url"
    },
    "hash": "datasifthash",
    "status": true
}
```

### curl Example

```
curl -XPOST http://api.cxengage.com/tenants/{{tenant-name}}/listeners \
     -H 'Authorization: Bearer {{token}}' \
-H 'Content-Type: application/json; charset=utf-8' \
-d '{"name":"Demo Datasift","type":"datasift","mapping":{"username":"interaction.author.username","sentiment":"salience.content.sentiment","id":"twitter.user.screen_name"},"hash":{{{datasift-hash}},"status":true}'
```
