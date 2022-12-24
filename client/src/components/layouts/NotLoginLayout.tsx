import React, {FC} from 'react';

interface NotLoginLayoutProps {
    children?: React.ReactNode
}

const NotLoginLayout: FC<NotLoginLayoutProps> = ({children}) => {
    return (
        <div className="text-slate-800 flex bg-white dark:bg-slate-900 dark:text-slate-400">
            <div className="container mx-auto min-h-screen flex flex-col items-center">
                {children}
            </div>
        </div>

    );
};

export default NotLoginLayout;