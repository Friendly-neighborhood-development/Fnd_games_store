import React, {FC} from 'react';

interface NotLoginLayoutProps {
    children?: React.ReactNode
}

const NotLoginLayout: FC<NotLoginLayoutProps> = ({children}) => {
    return (
        <div className="text-slate-800 dark:text-slate-400 bg-white dark:bg-slate-900 flex">
            <div className="container mx-auto min-h-screen flex flex-col items-center">
                {children}
            </div>
        </div>

    );
};

export default NotLoginLayout;