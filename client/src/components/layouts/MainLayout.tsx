import React, {FC} from 'react';
import Header from "../Header/Header";
import SmallScreenHeader from "../Header/SmallScreenHeader";

interface MainLayoutProps {
    children?: React.ReactNode
}

const MainLayout: FC<MainLayoutProps> = ({children}) => {
    return (
        <div className="text-slate-800 dark:text-slate-400 bg-gray-100 dark:bg-slate-900 flex flex-col min-h-screen ">
            <Header/>
            <SmallScreenHeader/>
            <main className="container mx-auto relative">
                {children}
            </main>
        </div>

    );
};

export default MainLayout;