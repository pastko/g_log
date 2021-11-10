import type { NextPage } from 'next';
import Head from 'next/head';
import Header from '../components/common/Header';
import Home from './Home';

const index: NextPage = () => {
  return (
    <>
      <Head>
        <title>glog</title>
        <meta name="description" content="post management" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Header accessToken='none'/>
      <Home />
    </>
  );
};

export default index;
