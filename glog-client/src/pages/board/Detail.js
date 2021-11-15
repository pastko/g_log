import styled from "styled-components";
import Header from '../../components/board/detail/Header';
import Contents from '../../components/board/detail/Contents';
import UserInfo from "../../components/board/element/UserInfo";
import Comment from "../../components/board/comment/Comment";
import Sidebar from '../../components/board/detail/Sidebar';

function Detail() {
    return (
        <StyledDetail>
            <StyledSidebar>
                <Sidebar />
            </StyledSidebar>
            <StyledContentsWrap>
                <Header />
                <UserInfo />
                <Contents />
                <Comment />
            </StyledContentsWrap>
            <StyledSideMenu>

            </StyledSideMenu>
        </StyledDetail>
    );
}
const StyledDetail = styled.div`
    position: relative;
    max-width: 1280px;
    margin: 0 auto;
    @media (max-width: 1440px) {
        width : 1280px;
    }
    @media (max-width: 1280px) {
        width: 768px;
    }
    @media (max-width: 768px) {
        width: 100vw;
    }
`;
const StyledSidebar = styled.div`
    width: 6vw;
    position: fixed;
    left: 50vw;
    margin-left: -37.5rem;

`;
const StyledContentsWrap = styled.div`
    width: 768px;
    margin: 0 auto;
`;

const StyledSideMenu = styled.div`
    position: absolute;
    right: 0;
    width: 10vw;
`;

export default Detail;