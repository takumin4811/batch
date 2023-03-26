
id=`curl -s -X POST -H "Content-Type:application/json" http://localhost:8080/hello/api/job -d '{"jobid": "1","jobname":"sampleJob--1"}'`
echo id = ${id}
url=http://localhost:8080/hello/api/job/${id}

jobstatus=`curl -s $url`

while [ $jobstatus = '"STARTED"' ]; do
   sleep 3
   jobstatus=`curl -s $url`
done
echo $jobstatus


curl http://localhost:8080/hello/api/job/details/${id}




curl --noproxy localhost -s -X POST -H "Content-Type:application/json" http://localhost:8080/hello/api/job -d '{"jobid":"1","jobname":"sampleJob1"}'

