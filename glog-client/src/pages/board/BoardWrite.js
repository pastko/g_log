import styled from 'styled-components';
import BoardEditor from '../../components/board/BoardEditor';
import BoardTag from '../../components/board/BoardTag';
import BoardTitle from '../../components/board/BoardTitle';

function BoardTemplate() {
    return (
        <>
            <StyledWrapper>
                <StyledHeader>
                    <BoardTitle />
                    <BoardTag />
                </StyledHeader>
                <StyledBody />
            </StyledWrapper>
        </>
    );
}

const StyledWrapper = styled.div`
    height: 100%;
    min-height: 0px;
    display: flex;
    flex-direction: column;
`;

const StyledHeader = styled.div`
    height: 30%;
    padding: 0 1rem;
`;

const StyledBody = styled(BoardEditor)`
    position: fixed;
    bottom: 80%;
    height: auto;
`;

export default BoardTemplate;
