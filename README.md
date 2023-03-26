# Getting Started

### Spring batch service のビルド
```
./gradlew bootjar
```

### Spring batch service の起動

```
java <JAR名>
```


### JOBの起動

```

//JOBの登録（リクエスト）　リクエスト後、JOBの実行IDが即時返される。JOBは非同期で実行される

id=`curl -s -X POST -H "Content-Type:application/json" http://localhost:8080/hello/api/job -d '{"jobid": "1","jobname":"sampleJob--1"}'`
echo id = ${id}
url=http://localhost:8080/hello/api/job/${id}

//実行結果の取得
jobstatus=`curl -s $url`

while [ $jobstatus = '"STARTED"' ]; do
   sleep 3
   jobstatus=`curl -s $url`
done

//実行結果の表示
echo $jobstatus

//実行結果詳細の取得と表示
curl http://localhost:8080/hello/api/job/details/${id}

```



