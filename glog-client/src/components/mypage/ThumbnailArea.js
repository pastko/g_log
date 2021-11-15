import styled from "styled-components";
import Button from "../layout/Button";
import Images from "../layout/Images";

function ThumbnailArea() {
    const upload = () => {

    }
    return (
        <StyledThumbnailArea>
            <StyledThumbnail>
                <Images
                    src="/mypage/thumbnail/DefaultImg.png"
                    shape="circle"
                    width={150}
                    height={150}
                />
                <Button fullwidth _onClick={upload}>
                    이미지 업로드
                </Button>
                <Button isDefault fullwidth>
                    이미지 제거
                </Button>
            </StyledThumbnail>
            <StyledUserInfo>
                <h2>hwlee-study</h2>
                <Button isDefault>수정</Button>
            </StyledUserInfo>
        </StyledThumbnailArea>
    );
}
const StyledThumbnailArea = styled.div`
    width: 100%;
    margin: 0 auto;
    display: flex;
    justify-items: center;
`;
const StyledThumbnail = styled.div`
    width: 150px;
    button {
        margin-top: 0.8rem;
    }
`;
const StyledUserInfo = styled.div`
    width: 70%;
    border-left: 1px solid #ccc;
    margin-left: 1rem;
    padding-left: 1rem;
    text-align: left;
    h2 {
        font-size: 2.25rem;
        font-weight: 600;
        color: rgb(52, 58, 64);
        margin: 1rem 0 1rem;
    }
    button {
        padding: 0;
    }
`;
export default ThumbnailArea;