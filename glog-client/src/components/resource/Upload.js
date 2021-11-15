import React ,{useState} from 'react';
import AWS from 'aws-sdk'
import styled from 'styled-components';


const S3_BUCKET = process.env.REACT_APP_S3_UPLOAD_BUCKET;
const REGION = process.env.REACT_APP_S3_UPLOAD_REGION;


AWS.config.update({
    accessKeyId: process.env.REACT_APP_S3_UPLOAD_KEY,
    secretAccessKey: process.env.REACT_APP_S3_UPLOAD_SECRET
})

const myBucket = new AWS.S3({
    params: { Bucket: S3_BUCKET},
    region: REGION,
})

const UploadImageToS3WithNativeSdk = () => {

    const [progress , setProgress] = useState(0);
    const [selectedFile, setSelectedFile] = useState(null);

    const handleFileInput = (e) => {
        setSelectedFile(e.target.files[0]);
    }

    const uploadFile = (file) => {

        const params = {
            ACL: 'public-read',
            Body: file,
            Bucket: S3_BUCKET+"/post/",
            Key: file.name
        };

        myBucket.putObject(params)
            .on('httpUploadProgress', (evt) => {
                setProgress(Math.round((evt.loaded / evt.total) * 100))
            })
            .send((err) => {
                if (err) console.log(err)
            })
    }


    return <div>
        <Button type="file" onClick={handleFileInput}>이미지 선택</Button>
        <Button onClick={() => uploadFile(selectedFile)}>이미지 업로드</Button>
    </div>
}


const Button = styled.div`
    background-color: green;
    color: white;
    width: 140px;
    border: none;
    font-size: 15px;
    font-weight: 600;
    border-radius: 8px;
    height: 35px;
    margin: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
    :hover {
        cursor: pointer;
        opacity: 0.5;
    }
`;

// const Buttons = styled.input`
// background-color: green;
//     color: white;
//     width: 140px;
//     border: none;
//     font-size: 15px;
//     font-weight: 600;
//     border-radius: 8px;
//     height: 35px;
//     margin: 5px;
//     display: flex;
//     justify-content: center;
//     align-items: center;
//     :hover {
//         cursor: pointer;
//         opacity: 0.5;
//     }`;

export default UploadImageToS3WithNativeSdk;