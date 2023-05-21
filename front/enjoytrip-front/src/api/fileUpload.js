import AWS from "aws-sdk";
// AWS S3 설정
async function awsFileUpload(file) {
  const bucketName = process.env.VUE_APP_BUCKET_NAME;
  const region = process.env.VUE_APP_S3_REGION;
  const accessKeyId = process.env.VUE_APP_ACCESS_KEY_ID;
  const secretAccessKey = process.env.VUE_APP_SECRET_ACCESS_KEY;

  const s3 = new AWS.S3({
    region,
    accessKeyId,
    secretAccessKey,
  });

  const promise = new Promise((resolve, reject) => {
    // 중복파일을 올릴 수 있게 이름 변경
    let temp = file.name.split(".");
    let rand = Math.floor(Math.random() * 100).toString();
    let newFileName = "";
    temp[0] = temp[0] + rand;
    temp.forEach((str, index) => {
      if (index === temp.length - 1) newFileName += ".";
      newFileName += str;
    });

    console.log(file);
    // 파일 업로드
    const params = {
      Bucket: bucketName,
      Key: newFileName,
      Body: file,
      ContentType: file.type,
    };

    s3.upload(params, (err, data) => {
      if (err) {
        reject(err);
      } else {
        resolve(data.Location);
      }
    });
  });
  // AWS S3 인스턴스 생성

  return promise;
}

export { awsFileUpload };
