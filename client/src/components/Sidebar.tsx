import React, {FC, memo} from 'react';

interface SidebarProps {
    children: React.ReactNode
}

const Sidebar: FC<SidebarProps> = memo(({children}) => {
    return (
        <div className={"hidden lg:block fixed top-24 w-56 bg-white rounded-lg dark:bg-slate-800 p-3"}>
            {children}
        </div>
    );
});

export default Sidebar;