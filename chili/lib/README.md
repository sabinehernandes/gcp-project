# supabase-java
[![CircleCI](https://circleci.com/gh/Harium/supabase-java.svg?style=svg)](https://circleci.com/gh/Harium/supabase-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.harium.supabase/core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.harium.supabase/core/)

An unofficial Java client for [Supabase](https://supabase.com/).

### Features

Currently, this library has basic support to database operations and storage.


### Usage
```java
// Starting the client
SupabaseClient supabase = new SupabaseClient(YOUR_SUPABASE_URL, YOUR_SUPABASE_KEY);

// Listing all buckets
StorageAPI storageAPI = supabase.storage();
List<Bucket> buckets = storageAPI.listBuckets();

// Upload a file
storageAPI.upload("mybucket/test.txt", new byte[]{1,2,3,4,5});
```

#### Not implemented yet
- Authentication
- ...