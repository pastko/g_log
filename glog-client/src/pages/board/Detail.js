import styled from "styled-components";
import Header from '../../components/board/detail/Header';
import Contents from '../../components/board/detail/Contents';
import UserInfo from "../../components/board/element/UserInfo";
import Comment from "../../components/board/comment/Comment";


function Detail() {
    return (
        <StyledDetail>
            <Header />
            <Contents />
            <UserInfo />
            <Comment />
        </StyledDetail>
    );
}
const StyledDetail = styled.div`

`;

export default Detail;