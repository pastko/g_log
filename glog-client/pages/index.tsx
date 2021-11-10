import type { NextPage } from 'next';
import styles from '../styles/Home.module.css';
import Head from 'next/head';
import Header from '../components/common/Header';
import Main from './Main';

const Home: NextPage = () => {
  return (
    <>
      <Head>
        <title>glog</title>
        <meta name="description" content="post management" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Header accessToken='none'/>
      <main className={styles.main}>
        <Main />
      </main>
    </>
  );
};

export default Home;
