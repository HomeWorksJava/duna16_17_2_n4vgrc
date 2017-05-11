/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.lali.uvegtigris.framework.web;

import hu.lali.uvegtigris.framework.datamodel.MenuItem;
import hu.lali.uvegtigris.framework.datamodel.Group;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hu.lali.uvegtigris.framework.services.api.IRoleService;
import hu.lali.uvegtigris.framework.services.api.IMenuService;
import hu.lali.uvegtigris.framework.services.api.ICacheRoleService;

@WebFilter(filterName = "MenuFilter", urlPatterns = {"/html/*"})
public class MenuFilter implements Filter {
    Logger log = LoggerFactory.getLogger(MenuFilter.class.getSimpleName());

    @Inject
    IRoleService serviceRole;
    
    @Inject
    IMenuService serviceMenu;

    @Inject
    ICacheRoleService serviceCacheUserRoles;
    
    public MenuFilter() {
        log.debug("Create instance");
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        log.info("FILTER:" + MenuFilter.class.getName());
        HttpServletRequest req = (HttpServletRequest)request;
        String userName = req.getUserPrincipal().getName();

//user roles
        List<Group> roles = serviceCacheUserRoles.getRolesByUserName(userName);
        if(roles == null || roles.size() == 0){
            List<Group> allRoles = serviceRole.getAllRoles();
            for(Group role:allRoles){
                log.info(userName+":"+role.getGroup()+"="+req.isUserInRole(role.getGroup()));
                if(req.isUserInRole(role.getGroup())){
                    serviceCacheUserRoles.addUserRoleToCache(userName, role);
                }
            }
            roles = serviceCacheUserRoles.getRolesByUserName(userName);
        }

//menu items;        
        List<MenuItem> menuItems = new ArrayList<>();
        for(Group role : roles){
            menuItems.addAll(serviceMenu.getByRoleName(userName));
        }
        
//User Interface
        request.setAttribute("menuitems", menuItems);
        request.getServletContext().getRequestDispatcher("/html/header.jsp").include(request, response);
        chain.doFilter(request, response);
        request.getServletContext().getRequestDispatcher("/html/footer.jsp").include(request, response);

    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
    }
}